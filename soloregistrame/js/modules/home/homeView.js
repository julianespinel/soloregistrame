define(['jquery', 'underscore', 'backbone', 'text!../home/home-template.html'], 

    function($, _, Backbone, HomeTemplate) {

        var homeView = Backbone.View.extend({

            el: $('#page'),

            events: {

            },


            render: function() {

                console.log('homeView.render');

                var data = {};
                var compiledTemplate = _.template(HomeTemplate, data);
                $('#page').html(compiledTemplate);
            }
        });

        return new homeView;
    }
);