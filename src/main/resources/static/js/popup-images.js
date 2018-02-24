function () {

	function popupImage(id) {

		// Get the modal
		var modal = document.getElementById(id+".modal");

		// Get the image and insert it inside the modal - use its "alt" text as a caption
		modal.style.display = "block";

		// Get the <span> element that closes the modal
		var span = document.getElementsById(id+".close")[0];

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}
	}
}