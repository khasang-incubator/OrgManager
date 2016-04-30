<div class="container">
    <form class="form-signin">
        <h2 class="form-signin-heading">Добро пожаловать!</h2>
        <label for="inputLogin" class="sr-only">Login:</label>
        <input type="text" id="inputLogin" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="dropup">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Roles:
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                <li>User</li>
                <li>Manager</li>
                <li>Admin</li>
            </ul>
        </div>
        <button class="btn btn-md btn-success btn-block" type="submit">Add user!</button>
    </form>
</div>
