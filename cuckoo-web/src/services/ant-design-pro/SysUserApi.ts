// @ts-ignore
/* eslint-disable */
import {request} from '@umijs/max';

/** 此处后端没有提供注释 POST /api/sys/users/create */
export async function createSysUser(
  body: API.SysUserCreateRequest,
  options?: { [key: string]: any },
) {
  return request<API.RSysUserResponse>('/api/sys/users/create', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 DELETE /api/sys/users/delete/${param0} */
export async function deleteSysUserById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.deleteSysUserByIdParams,
  options?: { [key: string]: any },
) {
  const {id: param0, ...queryParams} = params;
  return request<API.RVoid>(`/api/sys/users/delete/${param0}`, {
    method: 'DELETE',
    params: {...queryParams},
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 GET /api/sys/users/id/${param0} */
export async function findSysUserById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.findSysUserByIdParams,
  options?: { [key: string]: any },
) {
  const {id: param0, ...queryParams} = params;
  return request<API.RSysUserResponse>(`/api/sys/users/id/${param0}`, {
    method: 'GET',
    params: {...queryParams},
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 GET /api/sys/users/list */
export async function findSysUserList(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.findSysUserListParams,
  options?: { [key: string]: any },
) {
  return request<API.RListSysUserResponse>('/api/sys/users/list', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 GET /api/sys/users/page */
export async function findSysUserPage(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.findSysUserPageParams,
  options?: { [key: string]: any },
) {
  return request<API.RPageSysUserResponse>('/api/sys/users/page', {
    method: 'GET',
    params: {
      ...params,
      pageable: undefined,
      ...params['pageable'],
    },
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 PATCH /api/sys/users/partial-update/${param0} */
export async function partialSysUserById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.partialSysUserByIdParams,
  body: API.SysUserUpdateRequest,
  options?: { [key: string]: any },
) {
  const {id: param0, ...queryParams} = params;
  return request<API.RSysUserResponse>(`/api/sys/users/partial-update/${param0}`, {
    method: 'PATCH',
    headers: {
      'Content-Type': 'application/json',
    },
    params: {...queryParams},
    data: body,
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 PUT /api/sys/users/update/${param0} */
export async function updateSysUserById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.updateSysUserByIdParams,
  body: API.SysUserUpdateRequest,
  options?: { [key: string]: any },
) {
  const {id: param0, ...queryParams} = params;
  return request<API.RSysUserResponse>(`/api/sys/users/update/${param0}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    params: {...queryParams},
    data: body,
    ...(options || {}),
  });
}
