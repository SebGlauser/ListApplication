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


    /**
     * @brief   constructor
     * @param   versionName the name of version of the android.
     * @param   versionNumber the number of the version of the android.
     */
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
     * @param   versionName the name of version of the android.
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
     * @param   versionNumber the number of the version of the android.
     */
    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

}
