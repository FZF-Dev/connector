import {Route, Routes} from "react-router-dom";
import PageNotFound from "../pages/error_pages/PageNotFound.tsx";
import Home from "../pages/home/Home.tsx";
import Login from "../pages/login/Login.tsx";
import Register from "../pages/register/Register.tsx";
import UserProfile from "../pages/user_profile/UserProfile.tsx";

const Router = () => {
    return (
        <Routes>
            <Route path='/' element={<h1 style={{backgroundColor: "red"}}>Connector</h1>}>
                <Route path='/home' element={<Home/>}/>
                <Route path='/login' element={<Login/>}/>
                <Route path='/register' element={<Register/>}/>
                <Route path='/user/:userId' element={<UserProfile/>}/>
                <Route path='*' element={<PageNotFound/>}/>
            </Route>
        </Routes>
    );
};


/*const mainRouterTree = createBrowserRouter([
    {
        path: '/',
        element: <h1>Base path</h1>,
        errorElement: <DefaultError />,
    },
    {
        path: '/home',
        element: <h2>Home</h2>
    },
    {
        path: '/login',
        element: <h2>Login</h2>
    },
    {
        path: "/register",
        element: <h2>Register</h2>
    },
    {
        path: "/user/:userId",
        element: <h2>User Profile</h2>
    }
]);*/


export default Router;