import React, { useState, useContext, useEffect } from "react";
import { Link } from "react-router-dom";
import { ContactoMascotaContext } from "../context/ContactoMascotaProvider";
import { useContactoMascota } from "../hooks/useContactoMascota";
import Avatar from "../AppContactoMascota/components/Avatar";

const Header = () => {
  const { user } = useContactoMascota();
  const { openLoginModal } = useContext(ContactoMascotaContext);

  const [isReportDropdownOpen, setReportDropdownOpen] = useState(false);

  const toggleReportDropdown = () => {
    setReportDropdownOpen(!isReportDropdownOpen);
  };

  return (
    <nav className="bg-white border-gray-200 dark:bg-gray-900">
      <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
        <Link
          to={"/"}
          className="flex items-center space-x-3 rtl:space-x-reverse"
        >
          <img
            src="/images/logo.png"
            className="h-14"
            alt="contacto mascota Logo"
          />
          <span className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">
            Contacto Mascota
          </span>
        </Link>

        <div className="flex justify-center items-center w-full md:w-auto md:order-2 space-x-3 md:space-x-0 rtl:space-x-reverse">
          {Object.values(user).length > 0 ? (
            <Avatar currentUser={user} />
          ) : (
            <>
              <Link to={"/auth/login"}>
                <button
                  onClick={openLoginModal}
                  type="button"
                  className="text-black border-red-600 border-2 mr-2 hover:bg-red-500 focus:ring-4 focus:outline-none focus:ring-red-500 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-red-600 dark:hover:bg-red-500 dark:focus:ring-red-500"
                >
                  Ingresar
                </button>
              </Link>
              <Link to={"/auth/register"}>
                <button
                  type="button"
                  className="text-black bg-primario hover:bg-red-500 focus:ring-4 focus:outline-none focus:ring-red-500 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-red-600 dark:hover:bg-red-500 dark:focus:ring-red-500"
                >
                  Registrar
                </button>
              </Link>
            </>
          )}
        </div>

        <div
          className="items-center justify-between w-full md:flex md:w-auto md:order-1"
          id="navbar-cta"
        >
          <ul className="flex flex-col gap-4 md:gap-0 font-medium p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-500 md:dark:bg-gray-900 dark:border-gray-500">
            <li>
              <Link
                to={"/"}
                className="block py-2 px-3 md:p-0 text-white bg-red-500 rounded md:bg-transparent md:text-red-500 md:dark:text-red-500"
                aria-current="page"
              >
                Inicio
              </Link>
            </li>
            <li>
              <div className="relative group">
                <button
                  onClick={toggleReportDropdown}
                  className="flex items-center text-gray-900  hover:text-gray-500 focus:outline-none"
                >
                  Reportados
                  <svg
                    className="w-4 h-4 ml-1 text-gray-900 "
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth="2"
                      d="M19 9l-7 7-7-7"
                    />
                  </svg>
                </button>
                {isReportDropdownOpen && (
                  <div className="absolute mt-2 w-48 bg-white rounded-md shadow-lg">
                    <Link
                      to={"/mascotasperdidas"}
                      className="block px-4 py-2 text-sm text-gray-500 hover:bg-gray-100"
                    >
                      Mascota perdida
                    </Link>
                    <Link
                      to={"/mascotasencontradas"}
                      className="block px-4 py-2 text-sm text-gray-500 hover:bg-gray-100"
                    >
                      Encontré una mascota
                    </Link>
                  </div>
                )}
              </div>
            </li>
            <li>
              <Link
                to={"/finalesfelices"}
                className="block py-2 px-3 md:p-0 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-red-500 md:dark:hover:text-red-500 dark:text-white dark:hover:bg-gray-500 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-500"
              >
                Finales felices
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};
export default Header;
