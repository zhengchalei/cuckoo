import React from "react";
import {message, Popconfirm} from "antd";
import {DeleteOutlined} from "@ant-design/icons";
import {deleteSysUserById} from "@/services/ant-design-pro/SysUserApi";


interface SysUserDeleteProps {
  data: API.SysUserResponse;
  onCancel: () => void;
}


const handleDelete = async (record: API.SysUserResponse, onCancel: () => void) => {
  try {
    const {success} = await deleteSysUserById({id: record.id});
    if (success) {
      message.success(`删除 '${record.username}' 成功`);
    }
    onCancel();
  } catch (error) {
    console.log(error)
  }
}

const DeleteSysUser: React.FC<SysUserDeleteProps> = ({data, onCancel}) => {

  return <>
    <Popconfirm
      key={'delete'}
      title={`删除`}
      description={`你是否确认删除系统用户 '${data.username}'?`}
      okText="删除"
      cancelText="取消"
      onConfirm={() => handleDelete(data, onCancel)}
    >
      <a type={"link"}>
        <DeleteOutlined/> 删除
      </a>
    </Popconfirm>
  </>
}

export default DeleteSysUser;
