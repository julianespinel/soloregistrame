define(['jquery', 'underscore', 'backbone', 'text!../error/error-template.html'], 

    function($, _, Backbone, ErrorTemplate) {

        var errorView = Backbone.View.extend({

            el: $('#page'),

            events: {

            },


            render: function() {

                console.log('errorView.render');

                var data = {};
                var compiledTemplate = _.template(ErrorTemplate, data);
                $('#page').html(compiledTemplate);
            }
        });

        return new errorView;
    }
);