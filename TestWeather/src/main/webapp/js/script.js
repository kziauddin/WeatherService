/**
 * 
 */
function loadJSON(path, success, error)
{
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                if (success)
                    success(JSON.parse(xhr.responseText));
            } else {
                if (error)
                    error(xhr);
            }
        }
    };
    xhr.open("GET", path, true);
    xhr.send();
}


function init() {
loadJSON('json/city.list.json',
         function(data) {
			var options = '';
			for(var i=0;i<data.length;i++){
			    options += '<option value="' + data[i].name + "," + data[i].country + '" />';
			}	
			document.getElementById("datalist1").innerHTML = options;
			},
         function(xhr) { console.error(xhr); }
);
	
}	

function callWeatherService(callback){
	//alert("call weather Service 123");
	let city = document.getElementById("city").value;
	var parambody = JSON.parse('{"q":"' + city  + '"}');
	//alert("request is " + q);
	
    var xobj = new XMLHttpRequest();
    xobj.overrideMimeType("application/json");
    var url = "http://localhost:8080/api/weather/";
    
    xobj.open('POST', url, true); 
    xobj.setRequestHeader('Content-type','application/json');
    xobj.setRequestHeader("Access-Control-Allow-Origin", "*");
   
    xobj.onreadystatechange = function () {
          if (xobj.readyState == 4 && xobj.status == "200") {
            callback(xobj.responseText);
          }
    };
    //alert(JSON.stringify(parambody));
    xobj.send(JSON.stringify(parambody));
    	
}

function showinPage(data)
{
  console.log("Show in page" + data);
  var mydata = JSON.parse(data);
  document.getElementById("heading").innerHTML = "Weather Details for city : " + document.getElementById("city").value;
  document.getElementById("date1").innerHTML = mydata.dt[0];
  document.getElementById("date2").innerHTML = mydata.dt[1];
  document.getElementById("date3").innerHTML = mydata.dt[2];
  document.getElementById("min1").innerHTML = mydata.low_temp[0];
  document.getElementById("min2").innerHTML = mydata.low_temp[1];
  document.getElementById("min3").innerHTML = mydata.low_temp[2];
  document.getElementById("max1").innerHTML = mydata.high_temp[0];
  document.getElementById("max2").innerHTML = mydata.high_temp[1];
  document.getElementById("max3").innerHTML = mydata.high_temp[2];
  document.getElementById("forecast1").innerHTML = mydata.main[0];
  document.getElementById("forecast2").innerHTML = mydata.main[1];
  document.getElementById("forecast3").innerHTML = mydata.main[2];
  if (mydata.advice[0] != null) document.getElementById("advice1").innerHTML = mydata.advice[0];
  if (mydata.advice[1] != null) document.getElementById("advice2").innerHTML = mydata.advice[1];
  if (mydata.advice[2] != null) document.getElementById("advice3").innerHTML = mydata.advice[2];
  document.getElementById("img1").src = mydata.icon[0];
  document.getElementById("img2").src = mydata.icon[1];
  document.getElementById("img3").src = mydata.icon[2];
}


