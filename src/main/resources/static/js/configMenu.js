/**
 * This JavaScript document serves for the functionality of delete buttons in 
 * manage's function. 
 */
function deleteMenu(menuId){
	$ajax({
		method: 'DELETE',
		url: 'http://localhost:8080/menu'+ menuId,	
	}).done(function(menu){
		console.log("Delete menu:"+menuId);
	});
}
$(document).ready(function () {
	var info = $('#info')
	//Handle delete buttons
    info.click(function (event) {
        var elem = $(event.target);
        if (elem.is('button')) {
            var menuDiv = elem.parent();
            var menuId = menuDiv.attr('id').split('-')[1];
            // menuDiv.remove()
            deleteMenu(menuId);
        }
    })
})