
function signIn()
{
	var username=document.forms["signin"]["username"].value;
	var pass=document.forms["signin"]["password"].value;
	if(username==null||username=="")
	{
		alert("לא הכנסת שם משתמש");
		return false;
	}
	else if(pass==null||pass=="")
	{
		alert("לא הכנסת סיסמא");
	}
	else{
		var result = moveTojava.signIn(username,pass);
		switch(result)
		{
			case "true":
				$.mobile.changePage("#volunteerMenu");
				break;
			case "false":
				alert("שם משתמש או סיסמא לא נכונים");
				break;
			case "unApproved":
			{
				$.mobile.changePage("#unApproved");
				break;
			}
			case "trueManager":
				$.mobile.changePage("#manager");
				break;
			case "falseManager":
				alert("מנהל: הסיסמא לא נכונה");
				break;
		}
	}
}


function signUp()
{
	var firstName=document.forms["signup"]["firstname"].value;
	var lastName=document.forms["signup"]["lastname"].value;
	var userName=document.forms["signup"]["username"].value;
	var pass=document.forms["signup"]["password"].value;
	var id=document.forms["signup"]["id"].value;
	var phoneNumber=document.forms["signup"]["phonenumber"].value;
	var email=document.forms["signup"]["email"].value;
	if(firstName==null||firstName=="")
	{
		alert("לא הכנסת שם פרטי");
		return false;
	}
	else if(lastName==null||lastName=="")
	{
		alert("לא הכנסת שם משפחה");
		return false;
	}
	else if(userName==null||userName=="")
	{
		alert("לא הכנסת שם משתמש");
		return false;
	}
	else if(pass==null||pass=="")
	{
		alert("לא הכנסת סיסמא");
		return false;
	}
	else if(id==null||id=="")
	{
		alert("לא הכנסת ת.ז");
		return false;
	}
	else if(phoneNumber==null||phoneNumber=="")
	{
		alert("לא הכנסת מספר טלפון");
		return false;
	}
	else if(email==null||email=="")
	{
		alert("לא הכנסת כתובת אימייל");
		return false;
	}
	else{
		var result = moveTojava.signUp(firstName,lastName,userName,pass,id,phoneNumber,email);
		//alert("signup! "+result);
		if(result=='true')
		{
			$.mobile.changePage("#afterSignUp");
		}
		else
		{
			//alert("שם משתמש בשימוש");
			$.mobile.changePage("#unRegisteredUser");
		}
	}
}


function chooseMap(length)
{
	for(var i =0;i<length;i++)
	{
		var rad=document.getElementById("rad"+i).checked;
		var map;
		//var result;
		if(rad)
		{
			map=document.getElementById("rad"+i).value;
			//result = moveTojava.chooseMap(map);
			
			$.mobile.changePage("#mapDits");
		}
	}
}
function switchMap()
{
	//session - how is the volunteer
	//moveTojava.switchMap();
	$.mobile.changePage("#chooseMaps");
}

function endOfDelivery()
{
	//session - how is the volunteer
	//moveTojava.endOfDelivery();
	$.mobile.changePage("#endOfDelivery");
}

function approveNewVolunteers(length)
{
	var jsonArr=[];
	for(var i =0;i<length;i++)
	{
		var check=document.getElementById("checkB"+i).checked;
		if(check)
		{
			var check=document.getElementById("checkB"+i).name;
			jsonArr.push(check);
		}
	}
	var result = moveTojava.approveNewVolunteers(jsonArr);
	if(jsonArr.length != 0)
	{
		location.reload();
	}
}
function releaseMap(mapName)
{
	
	//moveTojava.releaseMap(mapName);
}
function deleteMap(mapName)
{
	//moveTojava.deleteMap(mapName);
}
function addNewFamily()
{
	var firstname=document.forms["newFamily"]["firstname"].value;
	var lastname=document.forms["newFamily"]["lastname"].value;
	var phonenumber=document.forms["newFamily"]["phonenumber"].value;
	var cityName=document.forms["newFamily"]["cityName"].value;
	var streetName=document.forms["newFamily"]["streetName"].value;
	var houseNum=document.forms["newFamily"]["houseNum"].value;
	var appartNum=document.forms["newFamily"]["appartNum"].value;
	var comments=document.forms["newFamily"]["comments"].value;
	//moveTojava.addNewFamily(firstname,lastname,phonenumber,cityName,streetName,houseNum,appartNum,comments);
	$.mobile.changePage("#addNewMaps");
}
function editFamily()
{
	var firstName=document.forms["editFamily"]["firstname"].value;
	var lastName=document.forms["editFamily"]["lastname"].value;
	var phoneNumber=document.forms["editFamily"]["phonenumber"].value;
	var cityName=document.forms["editFamily"]["cityName"].value;
	var streetName=document.forms["editFamily"]["streetName"].value;
	var houseNum=document.forms["editFamily"]["houseNum"].value;
	var appartNum=document.forms["editFamily"]["appartNum"].value;
	var comments=document.forms["editFamily"]["comments"].value;
	//var result = moveTojava.editFamily(firstName,lastName,phoneNumber,cityName,streetName,houseNum,appartNum,comments);
	//if(result)
	//{
		$.mobile.changePage("#allMaps");
	//}
	//else
	//{
	//	alert("editFamily failed");
	//}
}
function teamFamiliesToMap(length)
{
	var json = '{ "families" : [';
	for(var i =0;i<length;i++)
	{
		var check=document.getElementById("checkA"+i).checked;
		if(check)
		{
			if(i!=0)
				{
					json = json.concat(",");
				}
			var check=document.getElementById("checkA"+i).name;
			var splitName = check.split("+");
			json = json.concat('{"firstName":'+splitName[0]+',"lastName":'+splitName[1]+'}');
		}
	}
	json = json.concat(']}');
	alert(json);
	//moveTojava.teamFamiliesToMap(json);
	//$.mobile.changePage("#addNewMaps");//לטעון את הדף מחדש עם המשפחות שנותרו	
}
function addNewMap()
{
	var areaName=document.forms["newMap"]["areaName"].value;
	alert(areaName);
}
function coming()
{
	//moveTojava.coming();
}
function isComing()
{
	//var result = moveTojava.isComing();
	if(result == true)
	{
		//$.mobile.changePage("#chooseMaps");
	}
	else
	{
		//$.mobile.changePage("#mapDits");
	}
}

function cookieObj(isManager,userName) {

    this.isManager = isManager;
    this.userName = userName;
    this.isMapSaved;
    this.mapName;
    createCookie();

    this.CreateCookie = function () {

        var d = new Date();
        d.setTime(d.getTime()+(exdays*24*60*60*1000));
        var expires = "expires="+d.toGMTString();
        document.cookie = cname + "=" + cvalue + "; " + expires;


    }
}
function test()
{
   alert("tesstt");
   moveTojava.test();
}