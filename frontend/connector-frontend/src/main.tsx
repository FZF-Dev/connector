import React from 'react';
import ReactDOM from 'react-dom/client';
import {RouterProvider} from "react-router";
import {createBrowserRouter} from "react-router-dom";
import Home from "./pages/home/Home.tsx";
import Login from "./pages/login/Login.tsx";
import Register from "./pages/register/Register.tsx";
import UserProfile from "./pages/user_profile/UserProfile.tsx";
import PageNotFound from "./pages/error_pages/PageNotFound.tsx";
import NavBar from "./components/navbar/NavBar.tsx";

const router = createBrowserRouter([
    {
        path: '/',
        element: <NavBar/>,
        children: [
            {
                path: '/',
                element: <Home/>,
            },
            {
                path: '/login',
                element: <Login />,
            },
            {
                path: "/register",
                element: <Register />
            },
            {
                path: "/user/:userId",
                element: <UserProfile />
            },
            {
                path: "*",
                element: <PageNotFound />
            }
        ],
    },
]);

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
      <RouterProvider router={router} />
  </React.StrictMode>
);
