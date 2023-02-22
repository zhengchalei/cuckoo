/**
 * @see https://umijs.org/zh-CN/plugins/plugin-access
 * */
export default function access(initialState: { currentUser?: API.SysUserResponse } | undefined) {
    const {currentUser} = initialState ?? {};
    return {
        admin: currentUser && currentUser.roles?.map(role => role.code).concat('admin'),
    };
}
