// @ts-ignore
/* eslint-disable */
import {request} from '@umijs/max';

/** 此处后端没有提供注释 POST /api/sys/roles/create */
export async function createSysRole(
    body: API.SysRoleCreateRequest,
    options?: { [key: string]: any },
) {
    return request<API.RSysRoleResponse>('/api/sys/roles/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        data: body,
        ...(options || {}),
    });
}

/** 此处后端没有提供注释 DELETE /api/sys/roles/delete/${param0} */
export async function deleteSysRoleById(
    // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
    params: API.deleteSysRoleByIdParams,
    options?: { [key: string]: any },
) {
    const {id: param0, ...queryParams} = params;
    return request<API.RVoid>(`/api/sys/roles/delete/${param0}`, {
        method: 'DELETE',
        params: {...queryParams},
        ...(options || {}),
    });
}

/** 此处后端没有提供注释 GET /api/sys/roles/id/${param0} */
export async function findSysRoleById(
    // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
    params: API.findSysRoleByIdParams,
    options?: { [key: string]: any },
) {
    const {id: param0, ...queryParams} = params;
    return request<API.RSysRoleResponse>(`/api/sys/roles/id/${param0}`, {
        method: 'GET',
        params: {...queryParams},
        ...(options || {}),
    });
}

/** 此处后端没有提供注释 GET /api/sys/roles/list */
export async function findSysRoleList(
    // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
    params: API.findSysRoleListParams,
    options?: { [key: string]: any },
) {
    return request<API.RListSysRoleResponse>('/api/sys/roles/list', {
        method: 'GET',
        params: {
            ...params,
        },
        ...(options || {}),
    });
}

/** 此处后端没有提供注释 GET /api/sys/roles/page */
export async function findSysRolePage(
    // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
    params: API.findSysRolePageParams,
    options?: { [key: string]: any },
) {
    return request<API.RPageSysRoleResponse>('/api/sys/roles/page', {
        method: 'GET',
        params: {
            ...params,
            pageable: undefined,
            ...params['pageable'],
        },
        ...(options || {}),
    });
}

/** 此处后端没有提供注释 PATCH /api/sys/roles/partial-update/${param0} */
export async function partialSysRoleById(
    // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
    params: API.partialSysRoleByIdParams,
    body: API.SysRoleUpdateRequest,
    options?: { [key: string]: any },
) {
    const {id: param0, ...queryParams} = params;
    return request<API.RSysRoleResponse>(`/api/sys/roles/partial-update/${param0}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
        },
        params: {...queryParams},
        data: body,
        ...(options || {}),
    });
}

/** 此处后端没有提供注释 PUT /api/sys/roles/update/${param0} */
export async function updateSysRoleById(
    // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
    params: API.updateSysRoleByIdParams,
    body: API.SysRoleUpdateRequest,
    options?: { [key: string]: any },
) {
    const {id: param0, ...queryParams} = params;
    return request<API.RSysRoleResponse>(`/api/sys/roles/update/${param0}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        params: {...queryParams},
        data: body,
        ...(options || {}),
    });
}
