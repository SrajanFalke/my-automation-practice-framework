package com.ui.pojo;

import java.util.List;

public class TestData {
List<User> data; // Yaha user as a generic use isliye hua hai qk agar aap testData folder ke andar testdata.json ki file dekhoge.
//data ek array type json hai uske andar humne email id and password ke object create kiye hai or isi ke liye ek class hai User ke naam ki.

// Getter and setter are using for get and set the user email id and password.
public List<User> getData() {
	return data;
}

public void setData(List<User> data) {
	this.data = data;
}

}
// iss pojo class ke baad we have to create a new class(LoginDataProvider.java) in our new package named com.ui.dataProvider.
