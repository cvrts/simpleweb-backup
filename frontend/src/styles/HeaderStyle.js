import styled from 'styled-components';

export const HeaderContainer = styled.header`
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 1rem 2rem;
    background-color: #ffffff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
`;

export const HeaderLeftLogo = styled.div`
    a {
        display: flex;
        align-items: center;
        text-decoration: none;
    
    img {
        height: 40px;
    }
}
`;

export const HeaderRightUtility = styled.div`
display: flex;
align-items: center;

.desktop-only {
    display: flex;
    gap: 1rem;
}

@media (max-width: 768px) {
    .desktop-only {
        display: none;
    }
}
`;

export const HeaderItem = styled.a`
color: #333;
text-decoration: none;
  cursor: pointer;
  transition: color 0.3s ease;

  &:hover {
    color: #007bff;
  }
`;

export const HeaderCenterCategories = styled.div`
  .header-nav {
    ul {
      display: flex;
      list-style-type: none;
      padding: 0;
      margin: 0;

      li {
        margin: 0 1rem;

        a {
          text-decoration: none;
          color: #333;
          transition: color 0.3s ease;

          &:hover {
            color: #007bff;
          }

          .text-mobile {
            display: none;
          }
        }
      }
    }
  }

  @media (max-width: 768px) {
    .header-nav ul {
      flex-direction: column;
      align-items: center;
    }
  }
`;

export const SearchModal = styled.div`
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  z-index: 1000;

  h2 {
    margin-bottom: 1rem;
  }

  input {
    width: 100%;
    padding: 0.5rem;
    margin-bottom: 1rem;
  }

  button {
    padding: 0.5rem 1rem;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;

    &:hover {
        background-color: #0056b3;
    }
  }
`;