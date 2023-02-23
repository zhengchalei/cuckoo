import {ModalForm, ProFormSelect, ProFormText} from "@ant-design/pro-components";
import {findSysRoleList} from "@/services/ant-design-pro/SysRoleApi";
import React from "react";
import {Form, message} from "antd";
import {EditOutlined} from "@ant-design/icons";
import {updateSysUserById} from "@/services/ant-design-pro/SysUserApi";

interface SysUserCreateFormProps {
  data: API.SysUserResponse;
  onCancel: () => void;
}

const roleSelect = async () => {
  const data = await findSysRoleList({});
  if (!data.data || data.success === false) return [];
  return data.data.map(role => ({label: role.name, value: role.id}));
}

const UpdateSysUserModal: React.FC<SysUserCreateFormProps> = ({data, onCancel}) => {
  const [form] = Form.useForm<API.SysUserUpdateRequest>();
  form.setFieldsValue(data)
  return <>
    <ModalForm
      autoFocusFirstInput
      form={form}
      title="创建系统用户"
      submitTimeout={2000}
      width={500}
      layout={'vertical'}
      trigger={
        <a key={'edit'} type={"link"}>
          <EditOutlined/> 编辑
        </a>
      }
      modalProps={{
        destroyOnClose: true,
      }}
      onFinish={async (values) => {
        try {
          const {success, errorMessage} = await updateSysUserById({id: data.id}, values)
          if (success) {
            message.success('提交成功');
            onCancel();
            return true;
          }
          message.error(errorMessage);
          return false;
        } catch (error) {
          console.log(error)
          return false;
        }
      }}
    >
      <ProFormText
        name="username"
        label="用户名"
        tooltip="最长为 24 位"
        placeholder="请输入用户名"
        rules={[{required: true, message: '请输入用户名!'}]}
      />

      <ProFormSelect
        name="roleIds"
        mode={'multiple'}
        label="所属角色"
        tooltip="赋予当前用户角色所拥有的权限"
        placeholder="请选择所属角色"
        request={roleSelect}
        rules={[{required: true, message: '请选择角色!'}]}
      />

    </ModalForm>
  </>
}

export default UpdateSysUserModal;
