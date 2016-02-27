package com.santi.anibattle.box2d;

import com.santi.anibattle.enums.UserDataType;

public class GroundUserData extends UserData {

    public GroundUserData(float width, float height){
        super(width,height);
        userDataType = UserDataType.GROUND;
    }

}
