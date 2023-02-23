import {ActionType, PageContainer, ProColumns, ProTable} from "@ant-design/pro-components";
import {useRef} from "react";
import {findSysUserPage} from "@/services/ant-design-pro/SysUserApi";
import {findSysRoleList} from "@/services/ant-design-pro/SysRoleApi";
import {Space} from "antd";
import CreateSysUserModal from "@/pages/System/SysUser/components/CreateSysUser";
import UpdateSysUserModal from "@/pages/System/SysUser/components/UpdateSysUser";
import DeleteSysUser from "@/pages/System/SysUser/components/DeleteSysUser";


const roleSelect = async () => {
  const data = await findSysRoleList({});
  if (!data.data || data.success === false) return [];
  return data.data.map(role => ({label: role.name, value: role.id}));
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
      <UpdateSysUserModal key={'edit'} data={record} onCancel={() => action?.reload()}/>,
      <DeleteSysUser key={'delete'} data={record} onCancel={() => action?.reload()}/>
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
      pagination={{
        pageSize: 20,
        showSizeChanger: true,
      }}
      toolBarRender={() => [
        <CreateSysUserModal key={'create'} onCancel={() => actionRef.current?.reload()}/>
      ]}
    />

  </PageContainer>
}

export default SysUserTableList;
