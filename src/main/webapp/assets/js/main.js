/**
 * Created by easikoglu on 31/01/16.
 */
$(function () {

    $('.list-group.checked-list-box .list-group-item').each(function () {

        // Settings
        var $widget = $(this),
            $checkbox = $('<input type="checkbox" class="hidden" />'),
            color = ($widget.data('color') ? $widget.data('color') : "primary"),
            style = ($widget.data('style') == "button" ? "btn-" : "list-group-item-"),
            settings = {
                on: {
                    icon: 'glyphicon glyphicon-check'
                },
                off: {
                    icon: 'glyphicon glyphicon-unchecked'
                }
            };

        $widget.css('cursor', 'pointer')
        $widget.append($checkbox);

        // Event Handlers
        $widget.on('click', function () {
            $checkbox.prop('checked', !$checkbox.is(':checked'));
            $checkbox.triggerHandler('change');
            updateDisplay();
        });
        $checkbox.on('change', function () {
            updateDisplay();
        });


        // Actions
        function updateDisplay() {
            var isChecked = $checkbox.is(':checked');

            // Set the button's state
            $widget.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $widget.find('.state-icon')
                .removeClass()
                .addClass('state-icon ' + settings[$widget.data('state')].icon);

            // Update the button's color
            if (isChecked) {
                $widget.addClass(style + color + ' active');
            } else {
                $widget.removeClass(style + color + ' active');
            }
        }

        // Initialization
        function init() {

            if ($widget.data('checked') == true) {
                $checkbox.prop('checked', !$checkbox.is(':checked'));
            }

            updateDisplay();

            // Inject the icon if applicable
            if ($widget.find('.state-icon').length == 0) {
                $widget.prepend('<span class="state-icon ' + settings[$widget.data('state')].icon + '"></span>');
            }
        }

        init();
    });

    $('.addTobasket').on("click", function () {
        var productID = $(this).data('productId');

        $(".modal-body #productId").val($(this).data('productId'));
        $(".modal-body #productName").val($(this).data('productName'));
        $(".modal-body #productPrice").val($(this).data('productPrice'));

    });

    $('#get-checked-data').on('click', function (event) {
        event.preventDefault();
        var checkedItems = new Array();
        var counter = 0;

        $("#check-list-box li.active").each(function (idx, li) {

            var addition = {
                id: $(li).data("additionId"),
                price: $(li).data("additionPrice"),
                name: $(li).data("additionName")

            }
            checkedItems[counter] = addition;


            counter++;
        });


        addToBasket(checkedItems);
        $('#myModal').modal('toggle');


    });
    $("#continue").on('click', function (event) {
        event.preventDefault();
        $('#myModal').modal('toggle');

    });

    $(".checkoutBtn").on('click', function (event) {

        $.ajax({
            url: '/placeOrder',
            type: 'post',
            contentType: "application/json",
            success: function (data) {
                if (data) {
                    location.href = "/";
                }
            },
            data: $('#userName').val(),
        });
    });


    $(".createProduct").on('click', function (event) {


        var product = {
            name: $("#productName").val(),
            price: $("#productPrice").val(),

        };


        $.ajax({
            url: '/admin/createProduct',
            type: 'post',
            contentType: "application/json",
            success: function (data) {
                if (data) {
                    location.href = "/admin";
                }
            },
            data: JSON.stringify(product),
        });
    });

    $(".createAddition").on('click', function (event) {


        var addition = {
            name: $("#additionName").val(),
            price: $("#additionPrice").val(),

        };


        $.ajax({
            url: '/admin/createAddition',
            type: 'post',
            contentType: "application/json",
            success: function (data) {
                if (data) {
                    location.href = "/admin";
                }
            },
            data: JSON.stringify(addition),
        });
    });

    function addToBasket(checkedItems) {

        var basket = {
            product: {
                productId: $("#productId").val(),
                name: $("#productName").val(),
                price: $("#productPrice").val(),

            },
            additions: checkedItems,
        };


        $.ajax({
            url: '/addToBasket',
            type: 'post',
            contentType: "application/json",
            success: function (data) {
                if (data) {
                    location.href = "/basket";
                }
            },
            data: JSON.stringify(basket),
        });


    }

});