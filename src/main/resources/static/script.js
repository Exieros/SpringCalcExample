let dispNum = '0';
let maxNumbers = 9;
let buff = '0';
let operation = '';
let afterequal = false;

function init() {

	setDisp(dispNum);

	$( '.num' ).click(function() {

		let num = $(this).text().trim();

		if( num==',' && dispNum.includes(',') )
			return;

		if( num==',' && dispNum=='0' )
			return;

		if(dispNum.replace(',','').replace('-','').length>=maxNumbers)
			return;

		if(dispNum=='0' || afterequal){
            afterequal = false;
			dispNum = num;
			setDisp(dispNum);

		}else{

			dispNum+=num;
			setDisp(dispNum);

		}

	});

	$( '.operation' ).click(function() {
		let operationname = $(this).attr('class').split(' ')[0];
		operation = operationname;
		$('.operation').removeClass('operationSelected');
		$(this).addClass('operationSelected');
		buff = dispNum
		dispNum = '0';
		setDisp(dispNum);
	});

	$( '.AC' ).click(function(){
		$( '#calcDisplay' ).text('0');
		dispNum = '0';
	})

	$( '.point' ).click(function(){
		if( dispNum.includes(',') || dispNum.replace(',','').length>maxNumbers-1 )
			return;
		if( afterequal ){
		    afterequal = false;
		    dispNum = '0,';
		    setDisp(dispNum);
		}else{
            dispNum+=',';
            setDisp(dispNum);
		}
	})

	$( '.PM' ).click(function(){
		if(dispNum=='0')
			return;
		dispNum = dispNum.includes('-') ? dispNum.slice(1) : '-'+dispNum
		setDisp(dispNum);
	})

	$( '.equals' ).click(function(){
		if(operation=='')
			return;
		if(operation=='divide' && dispNum=='0')
		    return;
		$('.operation').removeClass('operationSelected');
		console.log(buff, dispNum, operation)
		send(buff, dispNum, operation, function(a){
			//let response = parseFloat(JSON.parse(a).res.replace(',','.'));
			let response = JSON.parse(a);
			if(!response.success){
			    console.log(response.description);
			    return;
			}
			let result = response.res;
			console.log(result)

			if(result.toString().includes('.'))
			    result = result.toFixed( maxNumbers - result.toString().split('.')[0].length )
			dispNum = result.toString().replace(/0*$/,"").replace('.',',');
			setDisp(dispNum);
			afterequal = true;
		})
		operation = '';
	})
};

function setDisp(num){
	$( '#calcDisplay' ).text('');
	let numStr = num.toString();
	for(i=0;i<numStr.length;i++)
		$( '#calcDisplay' ).append( $(`<div class="dig">${numStr[i]}</div>`) )
}

function send(num1, num2, operation, callback){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			callback(xhr.response);
		}
	}
	xhr.open('GET', `http://localhost:8080/math/${operation}?num1=${num1.replace(',','.')}&num2=${num2.replace(',','.')}`, true);
	xhr.send('');
}