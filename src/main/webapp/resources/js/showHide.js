function showHideToggle(id){
	var component = document.getElementById(id);
	if(component.style.display =='block')
	{
		component.style.display = 'none';
	}else
	{
		component.style.display = 'block';
	}
}
