define(['backbone'],

    function(Backbone) {

        var developer = Backbone.Model.extend({

            urlRoot: '/soloregistrame2/developers',

            defaults: {

                id: null,
                fullname: '',
                username: '',
                password: ''
            },

            parse : function(response, xhr) {

                this.set({

                    id: response.id,
                    fullname: response.fullname,
                    username: response.username,
                    password: response.password,
                });
            },
        });

        return developer;
    }
);