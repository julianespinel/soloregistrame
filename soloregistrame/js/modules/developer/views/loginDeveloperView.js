define(['jquery', 'underscore', 'backbone', '../model/developer', '../collection/developerCollection',
    'text!../templates/login-developer.html'], 

    function($, _, Backbone, Developer, developerCollection, LoginDeveloperTemplate) {

        var developerView = Backbone.View.extend({

            el: $('#page'),

            collection: developerCollection,

            model: '',

            events: {

                "click #login-developer" : "authenticateDeveloper",
            },

            authenticateDeveloper: function() {

                var username = $("#username").val();
                var password = $("#password").val();

                var developer1 = new Developer({

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

                if (this.verifyCredentials(developer1, developer2)) {

                    // go to user profile and show github repos.
                    document.location.href = '#/developers/' + developer2.get('username');

                } else {

                    // show error.
                    document.location.href = "#/error/";
                }
            },

            verifyCredentials: function(developer1, developer2) {

                var sameUsername = (developer1.get('username') == developer2.get('username'));
                var samePassword = (developer1.get('password') == developer2.get('password'));

                return sameUsername && samePassword;
            },

            render: function() {

                console.log('developerView.render');

                var data = {};
                var compiledTemplate = _.template(LoginDeveloperTemplate, data);
                $('#page').html(compiledTemplate);
            }
        });

        return new developerView;
    }
);