package suplex.theblacklist.objects;

import java.io.Serializable;

/**
 * Created by Morgan on 19/12/2017.
 */

public class User implements Serializable{

    private long id;
    private String firstName;
    private String lastName;
    private String cellNo;
    private String email;
    private String password;
    private long companyId;
    private Boolean isAdmin;
    private int secureNum;
    private Boolean isBasic;

    public long getId() {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Boolean getIsBasic() {
        return isBasic;
    }

    public void setIsBasic(Boolean isBasic) {
        this.isBasic = isBasic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public void setIsAdmin(Boolean isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsAdmin()
    {
        return isAdmin;
    }

    public void setSecureNum(int secNum){
        this.secureNum = secNum;
    }

    public int getSecureNum(){
        return secureNum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
