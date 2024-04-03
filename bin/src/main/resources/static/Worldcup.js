function addMenu(menuId){
        var clickedImageIds = JSON.parse(localStorage.getItem('clickedImageIds')) || [];
        clickedImageIds.push(menuId);
        localStorage.setItem('clickedImageIds', JSON.stringify(clickedImageIds));
    }