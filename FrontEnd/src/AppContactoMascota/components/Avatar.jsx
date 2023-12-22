import { useState } from "react";
import { useContactoMascota } from "../../hooks/useContactoMascota";
import { useUserInfo } from "../../store/userInfo";
import { Link, useNavigate } from "react-router-dom";
import { useEffect } from "react";

const Avatar = ({ currentUser }) => {
  const valueStorage = JSON.parse(localStorage.getItem("userInfo")) ?? {};
  const { setUser } = useContactoMascota();
  const { name, lastName, phone } = currentUser;
  const logout = useUserInfo((state) => state.logout);
  const [isDropdownVisible, setDropdownVisible] = useState(false);

  const navigate = useNavigate();
  const toggleDropdown = () => {
    setDropdownVisible(!isDropdownVisible);
  };

  const handleLogout = () => {
    navigate("/");
    logout();
  };

  useEffect(() => {
    if (valueStorage.state.user.token === "") {
      setUser({});
    }
  }, [valueStorage]);

  return (
    <div>
      <div
        className="relative inline-flex items-center justify-center w-10 h-10 overflow-hidden bg-gray-100 rounded-full dark:bg-gray-600"
        onClick={toggleDropdown}
      >
        <span className="font-medium text-gray-600 dark:text-gray-300">
          {name?.at()}
          {lastName?.at()}
        </span>
      </div>

      {/* Dropdown menu */}
      <div
        id="userDropdown"
        className={`z-10 ${
          isDropdownVisible ? "" : "hidden"
        } bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700 dark:divide-gray-600 absolute right-2`}
      >
        <div className="px-4 py-3 text-sm text-gray-900 dark:text-white">
          <div>
            {name} {lastName}
          </div>
        </div>
        <ul
          className="py-2 text-sm text-gray-700 dark:text-gray-200"
          aria-labelledby="avatarButton"
        >
          <li>
            <Link
              to={"/auth/dashboard"}
              className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
            >
              Dashboard
            </Link>
          </li>
         
        </ul>
        <div className="py-1">
          <button
            type="button"
            onClick={handleLogout}
            className="w-full px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
          >
            Salir
          </button>
        </div>
      </div>
    </div>
  );
};

export default Avatar;
