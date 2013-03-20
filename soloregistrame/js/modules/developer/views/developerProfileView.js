define(['jquery', 'underscore', 'backbone', '../model/developer', '../collection/developerCollection',
    'text!../templates/developer-profile.html',
    'modules/repository/views/repositoryView'], 

    function($, _, Backbone, Developer, developerCollection, DeveloperProfileTemplate, repositoryView) {

        var developerView = Backbone.View.extend({

            el: $('#page'),

            collection: developerCollection,

            model: '',

            events: {

                'click #github-developer' : 'getDeveloperGitHubRepos',
            },

            initialize : function(username) {

                if (username != null) {

                    var developer = new Developer({
                        username: username
                    });

                    developer.fetch({
                        async: false,
                        data : $.param({"username" : username}),
                    });

                    this.model = developer;
                    this.model.bind("sync", this.render);
                }
            },

            getDeveloperGitHubRepos: function() {

                var gitHubUserName = $("#github-username").val();

                repositoryView.initialize(gitHubUserName);
                repositoryView.render();
            },

            render: function() {

                console.log('developerView.render');

                var data = {
                    developer: this.model
                };

                console.log(JSON.stringify(data));

                var compiledTemplate = _.template(DeveloperProfileTemplate, data);
                $('#page').html(compiledTemplate);
            }
        });

        return new developerView;
    }
);