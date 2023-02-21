/**
 * @see https://umijs.org/zh-CN/plugins/plugin-access
 * */
export default function access(initialState: { currentUser?: API.LoginResponse } | undefined) {
    const {currentUser} = initialState ?? {};
    return {
        canAdmin: currentUser && currentUser.data?.roles.map(role => role.code).concat('admin'),
    };
}
