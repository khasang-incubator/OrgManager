<div class="container">
    <form class="form-signin">
        <h2 class="form-signin-heading">Add user</h2>
        <label for="inputLogin">Login:</label>
        <input type="text" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenuRoles" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                Roles:
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuRoles">
                <li><a href="#">User</a></li>
                <li><a href="#">Manager</a></li>
                <li><a href="#">Admin</a></li>
            </ul>
        </div>
        <button class="btn btn-md btn-success btn-block" type="submit">Add user!</button>
    </form>
</div>
