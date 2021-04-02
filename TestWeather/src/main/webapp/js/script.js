/**
 * 
 */
 var wdata;
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

function callWeatherService(){
	alert("call weather Service " + wdata.length);
}


/*
function loadJSON(callback) {   

    var xobj = new XMLHttpRequest();
        xobj.overrideMimeType("application/json");
    xobj.open('GET', 'json/city.list.json', true); // Replace 'appDataServices' with the path to your file
    xobj.onreadystatechange = function () {
          if (xobj.readyState == 4 && xobj.status == "200") {
            // Required use of an anonymous callback as .open will NOT return a value but simply returns undefined in asynchronous mode
            callback(xobj.responseText);
          }
    };
    xobj.send(null);  
 }

function init() {
	//alert("init called");
 loadJSON(function(response) {
  // Parsing JSON string into object
    var actual_JSON = JSON.parse(response);
    //alert(actual_JSON);
	console.log(actual_JSON);
 });
}*/