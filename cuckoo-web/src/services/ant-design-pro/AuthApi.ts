// @ts-ignore
/* eslint-disable */
import {request} from '@umijs/max';

/** 此处后端没有提供注释 GET /api/auth/current-user */
export async function currentUser(options?: { [key: string]: any }) {
    return request<API.RSysUserResponse>('/api/auth/current-user', {
        method: 'GET',
        ...(options || {}),
    });
}

/** 此处后端没有提供注释 POST /api/auth/login/account */
export async function accountLogin(body: API.LoginRequest, options?: { [key: string]: any }) {
    return request<API.RLoginResponse>('/api/auth/login/account', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        data: body,
        ...(options || {}),
    });
}

/** 此处后端没有提供注释 POST /api/auth/login/out-login */
export async function outLogin(options?: { [key: string]: any }) {
    return request<API.RVoid>('/api/auth/login/out-login', {
        method: 'POST',
        ...(options || {}),
    });
}
