declare namespace API {
    type deleteSysRoleByIdParams = {
        id: number;
    };

    type deleteSysUserByIdParams = {
        id: number;
    };

    type findSysRoleByIdParams = {
        id: number;
    };

    type findSysRoleListParams = {
        name?: string;
    };

    type findSysRolePageParams = {
        pageable: Pageable;
        name?: string;
    };

    type findSysUserByIdParams = {
        id: number;
    };

    type findSysUserListParams = {
        username?: string;
    };

    type findSysUserPageParams = {
        pageable: Pageable;
        username?: string;
        roleId?: number;
    };

    type LoginRequest = {
        username: string;
        password: string;
        rememberMe?: boolean;
    };

    type LoginResponse = {
        token?: string;
        expire?: number;
        data?: SysUserResponse;
    };

    type Pageable = {
        page?: number;
        size?: number;
        sort?: string[];
    };

    type partialSysRoleByIdParams = {
        id: number;
    };

    type partialSysUserByIdParams = {
        id: number;
    };

    type RListSysRoleResponse = {
        success?: boolean;
        errorMessage?: string;
        errorCode?: number;
        showType?: string;
        data?: SysRoleResponse[];
    };

    type RListSysUserResponse = {
        success?: boolean;
        errorMessage?: string;
        errorCode?: number;
        showType?: string;
        data?: SysUserResponse[];
    };

    type RLoginResponse = {
        success?: boolean;
        errorMessage?: string;
        errorCode?: number;
        showType?: string;
        data?: LoginResponse;
    };

    type RPageSysRoleResponse = {
        success?: boolean;
        errorMessage?: string;
        errorCode?: number;
        showType?: string;
        data?: SysRoleResponse[];
        total?: number;
    };

    type RPageSysUserResponse = {
        success?: boolean;
        errorMessage?: string;
        errorCode?: number;
        showType?: string;
        data?: SysUserResponse[];
        total?: number;
    };

    type RSysRoleResponse = {
        success?: boolean;
        errorMessage?: string;
        errorCode?: number;
        showType?: string;
        data?: SysRoleResponse;
    };

    type RSysUserResponse = {
        success?: boolean;
        errorMessage?: string;
        errorCode?: number;
        showType?: string;
        data?: SysUserResponse;
    };

    type RVoid = {
        success?: boolean;
        errorMessage?: string;
        errorCode?: number;
        showType?: string;
        data?: Record<string, any>;
    };

    type SysRoleCreateRequest = {
        /** 角色名 */
        name: string;
        /** 角色编码 */
        code: string;
        description?: string;
    };

    type SysRoleResponse = {
        /** id */
        id: number;
        /** 角色名 */
        name: string;
        /** 角色编码 */
        code: string;
        description?: string;
    };

    type SysRoleUpdateRequest = {
        /** id */
        id: number;
        /** 角色名 */
        name: string;
        /** 角色编码 */
        code: string;
        description?: string;
    };

    type SysUserCreateRequest = {
        /** 用户名 */
        username: string;
        /** 头像 */
        avatar?: string;
        /** 角色 */
        roleIds: number[];
    };

    type SysUserResponse = {
        /** id */
        id: number;
        /** 用户名 */
        username: string;
        /** 头像 */
        avatar?: string;
        /** 角色 */
        roles: SysRoleResponse[];
        /** 角色id */
        roleIds: number[];
    };

    type SysUserUpdateRequest = {
        /** id */
        id: number;
        /** 用户名 */
        username: string;
        /** 密码 */
        password: string;
        /** 头像 */
        avatar?: string;
        /** 角色 */
        roleIds: number[];
    };

    type updateSysRoleByIdParams = {
        id: number;
    };

    type updateSysUserByIdParams = {
        id: number;
    };
}
