<div class="question">
	<form action="" name="sub">
		<div class="row">
			${qNo } : <input type="text" name="sub_question_${qNo }"> 
			<select name="sub_choice"
				onchange="onChangeSubChoice(this,${qNo},${ansNo})">
				<option>Select</option>
				<option value="text">Multiline Text</option>
				<option value="sc">Single Choice</option>
				<option value="mc">Multi Choice</option>
			</select>
		</div>

		<div class="row ans-class" id="subQuestion_answer_${ansNo}_${qNo}"></div>
	</form>
</div>