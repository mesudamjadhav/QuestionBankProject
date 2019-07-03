
<div class="question">
	<form action="" name="main">
		<div class="row">

			${qNo } : <input type="text" name="question_${qNo }"> 
			<select name="choice"
				onchange="onChangeChoice(this,${qNo })">
				<option>Select</option>
				<option value="text">Multiline Text</option>
				<option value="sc">Single Choice</option>
				<option value="mc">Multi Choice</option>
			</select>
		</div>

		<div class="row ans-class" id="answer_${qNo}"></div>
	</form>
</div>