import {ActionType, PageContainer, ProColumns, ProCoreActionType, ProTable} from "@ant-design/pro-components";
import {useRef} from "react";
import {deleteSysUserById, findSysUserPage} from "@/services/ant-design-pro/SysUserApi";
import {findSysRoleList} from "@/services/ant-design-pro/SysRoleApi";
import {message, Popconfirm, Space} from "antd";
import CreateSysUserModal from "@/pages/System/SysUser/components/CreateSysUser";
import {DeleteOutlined, EditOutlined, ProfileOutlined} from "@ant-design/icons";

const roleSelect = async () => {
    const data = await findSysRoleList({});
    if (!data.data || data.success === false) return [];
    return data.data.map(role => ({label: role.name, value: role.id}));
}


const handleDelete = async (record: API.SysUserResponse, action: ProCoreActionType | undefined) => {
    try {
        const {success} = await deleteSysUserById({id: record.id});
        if (success) {
            message.success(`删除 '${record.username}' 成功`);
        }
        action?.reload();
    } catch (error) {
        console.log(error)
    }
}

const columns: ProColumns<API.SysUserResponse>[] = [
    {
        title: '用户名',
        dataIndex: 'username',
        copyable: true,
        ellipsis: true,
        tip: '登录使用的用户名',
        formItemProps: {
            rules: [
                {
                    required: true,
                    message: '用户名为必填项',
                },
            ],
        },
    },
    {
        title: '角色',
        dataIndex: 'roleIds',
        ellipsis: true,
        valueType: 'select',
        tip: '所拥有的的角色',
        request: roleSelect,
        params: {},
    },
    {
        title: '头像',
        dataIndex: 'avatar',
        key: 'avatar',
        valueType: 'avatar',
        width: 150,
        search: false,
        render: (dom) => (
            <Space>
                <span>{dom}</span>
            </Space>
        ),
    },
    {
        title: '操作',
        valueType: 'option',
        key: 'option',
        render: (text, record, _, action) => [
            <a key={'edit'} type={"link"} color={''}>
                <EditOutlined/> 编辑
            </a>,
            <a key={'view'} type={"link"}>
                <ProfileOutlined/> 查看
            </a>,
            <Popconfirm
                key={'delete'}
                title={`删除`}
                description={`你是否确认删除系统用户 '${record.username}'?`}
                okText="删除"
                cancelText="取消"
                onConfirm={() => handleDelete(record, action)}
            >
                <a type={"link"}>
                    <DeleteOutlined/> 删除
                </a>
            </Popconfirm>,
        ]
    }
]


const SysUserTableList = () => {
    const actionRef = useRef<ActionType>();
    return <PageContainer>
        <ProTable<API.SysUserResponse>
            columns={columns}
            actionRef={actionRef}
            rowKey="id"
            search={{labelWidth: 'auto'}}
            request={async (params, sorter, filter) => {
                console.log(params, sorter, filter);
                return await findSysUserPage({
                    pageable: {
                        page: params.current,
                        size: params.pageSize,
                    },
                    username: params.username,
                    roleId: params.roleIds
                })
            }}
            pagination={{pageSize: 20}}
            toolBarRender={() => [
                <CreateSysUserModal key={'create'} onCancel={() => actionRef.current?.reload()}/>
            ]}
        />

    </PageContainer>
}

export default SysUserTableList;
