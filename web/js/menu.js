$(document).ready(function() {

    // selector cache
    var $menuItem = $('.left-menu .menu a.item, .menu .link.item'),
        // alias
        handler = {

            activate: function() {
                if (!$(this).hasClass('dropdown browse')) {
                    $(this)
                        .addClass('active')
                        .closest('.ui.menu')
                        .find('.item')
                        .not($(this))
                        .removeClass('active');
                    var lk = $(this).attr("lk");
                    $("#main").load(lk+".jsp");
                }
            }

        };

    $menuItem
        .on('click', handler.activate);

});


