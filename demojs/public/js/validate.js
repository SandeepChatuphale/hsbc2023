/**
 * 
 */
 function changeButtonStatus(btnStatus)
		{
			let loginBtn = document.getElementById("btn");			
			loginBtn.disabled = btnStatus;
		}
		function loginUserName()
		{
			let username = document.getElementById("uName").value;
			
			if(username == "")
			{
				document.getElementById("usernameerror").innerHTML = "User name is MUST";
				changeButtonStatus(true);
			}
			else
				changeButtonStatus(false);
		}
		function loginPassword()
		{
			let pwd = document.getElementById("pwd").value;
			
			if(pwd == "")
			{
				document.getElementById("pwderror").innerHTML = "Password is MUST";
				changeButtonStatus(true);
			}
			else
				changeButtonStatus(false);
		}		
		
function showDetails()
{
	let username = document.getElementById("uName").value;
	let pwd = document.getElementById("pwd").value;
	
	let data = "Entered details are  " + username + "   " + pwd;

	document.getElementById("output").innerHTML = data			
}













