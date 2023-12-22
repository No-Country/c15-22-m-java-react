import React from "react";

const Footer = () => {
  return (
    <footer className=" dark:bg-gray-900 border-4">
      <div className="container flex flex-col items-center justify-between p-6 mx-auto space-y-4 sm:space-y-0 sm:flex-row">
        <a href="#">
          <img className="w-auto h-8" src="/images/logoContacto.png" alt="" />
        </a>

        <p className="text-sm text-gray-600 dark:text-gray-300">
          © Copyright 2023. All Rights Reserved.
        </p>
      </div>
    </footer>
  );
};

export default Footer;
