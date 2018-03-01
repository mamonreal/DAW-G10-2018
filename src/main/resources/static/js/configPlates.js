/**
 * This JavaScript document serves for the functionality of delete buttons in 
 * manage's function. 
 */
function deleteProduct(productId){
	$ajax({
		method: 'DELETE',
		url: 'http://localhost:8080/plates'+ productId,	
	}).done(function(product){
		console.log("Delete product:"+productId);
	});
}
$(document).ready(function () {
	var info = $('#info')
	//Handle delete buttons
    info.click(function (event) {
        var elem = $(event.target);
        if (elem.is('button')) {
            var productDiv = elem.parent();
            var productId = productDiv.attr('id').split('-')[1];
            // productDiv.remove()
            deleteProduct(productId);
        }
    })
})