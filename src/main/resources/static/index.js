 (function () {

       // Note:
       // On create/update you should render a form with a number of fields. There is no need to render it each time.
       // You can code one time using HTML (not dynamically using JS like we did with table) and then just show or hide it using CSS style: "display: none" to hide and "display: block" to show;
       // To display it in a modal you can either add any library like jQuery/jQuery UI or do it manually using CSS.
       // It is not required to add modal popups but definitely would give you additional scores.

       fetch('/users').then(function (response) {
             return response.json();
       }).then(function (data) {
             var users = [];
             for (var i in data) {
                   var record = data[i];

                   var user = new User(record.id, record.username);
                   users.push(user);
             }

             users = new UserList(users);
             users.render();
       }).catch(function(){
             alert(JSON.stringify(arguments));
       });

       function User(id, name) {
             this.id = id;
             this.name = name;

             this.render = function () {
                   //TODO render user details in a separate section or "preferably" modal popup
             }

             this.create = function () {
                   fetch('/users', {
                         method: 'post',
                         body: JSON.stringify(this.user),
                         headers: {
                               'Content-Type': 'application/json'
                         }
                   })

                   // TODO using Promise API add handlers when request is finished of failed
                   // For example when user is created display a notification
                   // And if request fails display an error. NB use different styles for system errors like network issues or somthing like that and application errors (validation/???)
             }

             this.update = function () {
                   // TODO
             }

             this.delete = function () {
                   // TODO
             }

             this.renderEditForm = function () {
                   // TODO render form where client can edit user information and submit/cancel buttons
                   // when client clicks on submit button invoke user.update();
                   // when client clicks on cancel button hide form;
             }
       }

       function UserList(users) {
             this.users = users;

             this.render = function () {
                   var createUserBtn = document.createElement('button');
                   createUserBtn.innerText = "Create User";
                   createUserBtn.addEventListener('click', function () {
                         // TODO render user form with submit/cancel buttons
                         // when client clicks on submit button read form fields and create User object. Then invoke create() method.
                         // when client clicks on cancel button hide form;
                   });
                   document.body.appendChild(createUserBtn);

                   var table = document.createElement('table');
                   document.body.appendChild(table);

                   for (var i in this.users) {
                         var user = this.users[i];

                         var tr = table.insertRow();

                         Object.keys(user).forEach(function (fieldName) {
                               var fieldValue = user[fieldName];
                               // just for fun you can remove this if statement and see whats happen.
                               // If you could explain why it happens you will get additional scores
                               if (typeof fieldValue !== 'function') {
                                     var td = tr.insertCell();
                                     td.innerText = user[fieldName];
                               }
                         });

                         // Try to turn these two cells into icons for additional scores.
                         var editIconCell = tr.insertCell();
                         editIconCell.classList.add('edit-icon');
                         editIconCell.id = 'edit-icon-' + user.id;
                         editIconCell.innerText = "Edit";

                         var deleteIconCell = tr.insertCell();
                         deleteIconCell.classList.add('delete-icon');
                         deleteIconCell.id = 'delete-icon-' + user.id;
                         deleteIconCell.innerText = "Delete";

                         bindEventListeners(editIconCell, deleteIconCell, user);
                   }
             }


             function bindEventListeners(editIconCell, deleteIconCell, user) {
                   editIconCell.addEventListener('click', function () {
                         user.renderEditForm();
                   });

                   deleteIconCell.addEventListener('click', function () {
                         user.delete();
                   });
             }
       }

 })();
