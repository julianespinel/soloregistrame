define(['jquery', 'underscore', 'backbone', '../model/developer', '../collection/developerCollection',
    'text!../templates/register-developer.html'], 

    function($, _, Backbone, Developer, developerCollection, RegisterDeveloperTemplate) {

        var developerView = Backbone.View.extend({

            el: $('#page'),

            collection: developerCollection,

            events: {

                "click #register-developer" : "createDeveloper",
            },

            createDeveloper: function() {

                var fullname = $("#fullname").val();
                var username = $("#username").val();
                var password = $("#password").val();

                var newDeveloper = new Developer({

                    fullname: fullname,
                    username: username,
                    password: password
                });

                var developer2 = new Developer({

                    username: username
                });

                developer2.fetch({
                    async: false,
                    data : $.param({"username" : username}),
                });

                if (developer2.get('id') == null) {

                    developerCollection.create(newDeveloper);
                    document.location.href = '#/developers/' + developer2.get('username');

                } else {

                    document.location.href = "#/error/";
                }
            },

            render: function() {

                console.log('developerView.render');

                var data = {};
                var compiledTemplate = _.template(RegisterDeveloperTemplate, data);
                $('#page').html(compiledTemplate);
            }
        });

        return new developerView;
    }
);