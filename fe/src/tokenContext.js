// TokenContext.js
import React, { createContext, useContext } from 'react';

const TokenContext = createContext();

export const useToken = () => {
  return useContext(TokenContext);
};

export const TokenProvider = ({ token, children }) => {
  return (
    <TokenContext.Provider value={token}>
      {children}
    </TokenContext.Provider>
  );
};

