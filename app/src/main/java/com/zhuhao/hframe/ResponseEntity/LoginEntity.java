package com.zhuhao.hframe.ResponseEntity;

/**
 * Author : zhuhao
 * Date : 3/9/2017
 *
 * @Last Modified Time :3/9/2017
 * Description :
 */

public class LoginEntity {
    /**
     * userId : 1
     * userName : henry
     * groupId : 0
     * headUrl : images/JPEG_20170718_111146985.jpg
     */

    private int userId;
    private String userName;
    private int groupId;
    private String headUrl;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
