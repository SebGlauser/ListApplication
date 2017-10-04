package com.sebastienglauser.listapplication.objects;

/**
 * @Author Sebastien Glauser
 *
 * @date  28.09.2017
 *
 * @brief Object class used to list all android version
 */

public class AndroidVersion
{
    private String versionName;         ///< The version name of the android version
    private String versionNumber;       ///< The version number of the android version

    public AndroidVersion(String versionName, String versionNumber){
        this.versionName = versionName;
        this.versionNumber = versionNumber;
    }

    /**
     * @brief   Used to retrun the version name of the android version
     * @return  The android version
    */
    public String getVersionName() {
        return versionName;
    }

    /**
     * @brief   Used to set the version name of the android version
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    /**
     * @brief   Used to retrun the version number of the android version
     * @return  The android version
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * @brief   Used to set the version number of the android version
     */
    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

}
