var qNo = 1;
function callAjax(url, callback) {
	$.ajax({
		method : "GET",
		url : url,
	}).done(function(data) {
		callback(data);
	});
}

function callPostAjax(url, data, callback) {
	$.ajax({
		method : "POST",
		url : url,
		data : data,
		dataType : "html",
		contentType : 'application/json',
		mimeType : 'application/json',
	}).done(function(data) {
		callback(data);
	});
}

function callPostAjaxForJson(url, data, callback) {
	$.ajax({
		method : "POST",
		url : url,
		data : data,
		dataType : "json",
		contentType : 'application/json',
		mimeType : 'application/json',
	}).done(function(data) {
		callback(data);
	});
}

function callAjaxForFileUpload(url, formData, callback) {
	$.ajax({
		url : url,
		type : 'POST',
		data : formData,
		processData : false,
		contentType : false,
		success : function(data) {
			callback(data);
		}
	});
}

function callForAddNewQuestion() {
	var callForAddNewQuestionCallBack = function(response) {
		qNo = qNo + 1;
		$("#dataContainer").append(response);
	};
	callPostAjax("./questionController/test?qNo=" + qNo, "",
			callForAddNewQuestionCallBack)
}

function callForAddSubQuestion(qno, ansNo) {
	var callForAddSubQuestionCallBack = function(response) {
		$("#subQuestion_" + ansNo + "_" + qno).html(response);
	};
	callPostAjax("./questionController/getSubQuestion?qNo=" + qno+"&ansNo="+ansNo, "",
			callForAddSubQuestionCallBack)
}

function onChangeChoice(e, qno) {
	if (e.value === "text") {
		var textAreaCallBack = function(response) {
			$("#answer_" + qno).html(response);
		};
		callPostAjax("./questionController/getTextArea?qNo=" + qno, "",
				textAreaCallBack)
	} else if (e.value === "sc") {
		var textAreaCallBack = function(response) {
			$("#answer_" + qno).html(response);
		};
		callPostAjax("./questionController/getSingleText?qNo=" + qno, "",
				textAreaCallBack)
	} else if (e.value === "mc") {
		var textAreaCallBack = function(response) {
			$("#answer_" + qno).html(response);
		};
		callPostAjax("./questionController/getMultiText?qNo=" + qno, "",
				textAreaCallBack)
	}

}

function onChangeSubChoice(e, qno,ans) {
	
//	var ansNo = e.name.;
	
	if (e.value === "text") {
		var textAreaCallBack = function(response) {
			$("#subQuestion_answer_"+ans+"_" + qno).html(response);
		};
		callPostAjax("./questionController/getSubTextArea?qNo=" + qno, "",
				textAreaCallBack)
	} else if (e.value === "sc") {
		var textAreaCallBack = function(response) {
			$("#subQuestion_answer_"+ans+"_" + qno).html(response);
		};
		callPostAjax("./questionController/getSubSingleText?qNo=" + qno, "",
				textAreaCallBack)
	} else if (e.value === "mc") {
		var textAreaCallBack = function(response) {
			$("#subQuestion_answer_"+ans+"_" + qno).html(response);
		};
		callPostAjax("./questionController/getSubMultiText?qNo=" + qno, "",
				textAreaCallBack)
	}

}

function getAllElementsFromDiv() {
	var forms = $("form");
	var data = [];

	var flag = false;

	for (var i = 0; i < forms.length; i++) {
		var questionData = {};
		var subQuestionData = {};
		var answers = [];
		var subAnswer = [];

		var answerData = {};
		
		var subAnswerData = {};
		for (var j = 0; j < forms[i].length; j++) {
			
			if(forms[i][j].type == 'button'){
				continue;
			}
			
			if (forms[i][j].name.startsWith('choice')) {
				questionData.choice = forms[i][j].value;
			}else if (forms[i][j].name.startsWith('sub')) {
				
				if (forms[i][j].name.startsWith('sub_choice')) {
					subQuestionData.choice = forms[i][j].value;
				}else if (forms[i][j].name.startsWith('sub_question')) {
					subQuestionData = {};
					answerData.subQuestion = subQuestionData;
					subQuestionData.questionName = forms[i][j].value;
				} else {
					subAnswerData.answerDesc = forms[i][j].value;
					subAnswer.push(subAnswerData);
					subQuestionData.answers = subAnswer;
					subAnswerData = {};
				}
			} else if (forms[i][j].name.startsWith('question')) {
				questionData.questionName = forms[i][j].value;
			} else {
				answerData = {};
				answerData.answerDesc = forms[i][j].value;
				answers.push(answerData);
			}
		}
		questionData.answers = answers;
		data.push(questionData);
	}
	var saveCallback = function(response) {

		console.log(response);
	};
	data = JSON.stringify(data);
	callPostAjaxForJson("./questionController/saveQuestions", data,
			saveCallback);
}
