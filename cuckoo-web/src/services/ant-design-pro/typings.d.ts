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
    /** ????????? */
    name: string;
    /** ???????????? */
    code: string;
    description?: string;
  };

  type SysRoleResponse = {
    /** id */
    id: number;
    /** ????????? */
    name: string;
    /** ???????????? */
    code: string;
    description?: string;
  };

  type SysRoleUpdateRequest = {
    /** ????????? */
    name: string;
    /** ???????????? */
    code: string;
    description?: string;
  };

  type SysUserCreateRequest = {
    /** ????????? */
    username: string;
    /** ?????? */
    avatar?: string;
    /** ?????? */
    roleIds: number[];
  };

  type SysUserResponse = {
    /** id */
    id: number;
    /** ????????? */
    username: string;
    /** ?????? */
    avatar?: string;
    /** ?????? */
    roles: SysRoleResponse[];
    /** ??????id */
    roleIds: number[];
  };

  type SysUserUpdateRequest = {
    /** ????????? */
    username: string;
    /** ?????? */
    password: string;
    /** ?????? */
    avatar?: string;
    /** ?????? */
    roleIds: number[];
  };

  type updateSysRoleByIdParams = {
    id: number;
  };

  type updateSysUserByIdParams = {
    id: number;
  };
}
