import {Outlet} from "react-router-dom";


const PageNotFound = () => {
    return (
        <div style={{ padding: 20 }}>
            <h2>404: Page Not Found</h2>
            <Outlet/>
        </div>
    );
};

export default PageNotFound;
