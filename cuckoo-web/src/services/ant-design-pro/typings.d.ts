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

    type findSysRolePage1Params = {
        name?: string;
    };

    type findSysRolePageParams = {
        pageable: Pageable;
        name?: string;
    };

    type findSysUserByIdParams = {
        id: number;
    };

    type findSysUserPage1Params = {
        username?: string;
    };

    type findSysUserPageParams = {
        pageable: Pageable;
        username?: string;
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

    type PageableObject = {
        offset?: number;
        sort?: SortObject;
        pageNumber?: number;
        pageSize?: number;
        paged?: boolean;
        unpaged?: boolean;
    };

    type PageSysRoleResponse = {
        totalElements?: number;
        totalPages?: number;
        size?: number;
        content?: SysRoleResponse[];
        number?: number;
        sort?: SortObject;
        numberOfElements?: number;
        pageable?: PageableObject;
        first?: boolean;
        last?: boolean;
        empty?: boolean;
    };

    type PageSysUserResponse = {
        totalElements?: number;
        totalPages?: number;
        size?: number;
        content?: SysUserResponse[];
        number?: number;
        sort?: SortObject;
        numberOfElements?: number;
        pageable?: PageableObject;
        first?: boolean;
        last?: boolean;
        empty?: boolean;
    };

    type partialSysRoleByIdParams = {
        id: number;
    };

    type partialSysUserByIdParams = {
        id: number;
    };

    type RListSysRoleResponse = {
        success?: boolean;
        code?: number;
        message?: string;
        errorMessage?: string;
        data?: SysRoleResponse[];
    };

    type RListSysUserResponse = {
        success?: boolean;
        code?: number;
        message?: string;
        errorMessage?: string;
        data?: SysUserResponse[];
    };

    type RLoginResponse = {
        success?: boolean;
        code?: number;
        message?: string;
        errorMessage?: string;
        data?: LoginResponse;
    };

    type RPageSysRoleResponse = {
        success?: boolean;
        code?: number;
        message?: string;
        errorMessage?: string;
        data?: PageSysRoleResponse;
    };

    type RPageSysUserResponse = {
        success?: boolean;
        code?: number;
        message?: string;
        errorMessage?: string;
        data?: PageSysUserResponse;
    };

    type RSysRoleResponse = {
        success?: boolean;
        code?: number;
        message?: string;
        errorMessage?: string;
        data?: SysRoleResponse;
    };

    type RSysUserResponse = {
        success?: boolean;
        code?: number;
        message?: string;
        errorMessage?: string;
        data?: SysUserResponse;
    };

    type RVoid = {
        success?: boolean;
        code?: number;
        message?: string;
        errorMessage?: string;
        data?: Record<string, any>;
    };

    type SortObject = {
        empty?: boolean;
        sorted?: boolean;
        unsorted?: boolean;
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

    type SysRoleSaveRequest = {
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

    type SysUserResponse = {
        /** id */
        id: number;
        /** 用户名 */
        username: string;
        /** 头像 */
        avatar?: string;
        /** 角色 */
        roles: SysRoleResponse[];
    };

    type SysUserSaveRequest = {
        /** 用户名 */
        username: string;
        /** 密码 */
        password: string;
        /** 头像 */
        avatar?: string;
        /** 角色 */
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
