import React, { useState } from 'react'

const Header = () => {
    const navigate = useNavigate()
    const [userId] = useState(window.sessionStorage.getItem('user_id'))
    const [userNickname] = useState(window.sessionStorage.getItem('user_nickname'))
    const [userRole] = useState(window.sessionStorage.getItem('user_role'))
    //auth 리덕스
    const userAuth = useSelector((state) => state.userAuth);
    const auth = userAuth.auth;

    //검색 모달 상태
    const [isSearchOpen, setIsSearchOpen] = useState(false);
    //검색값 저장
    const [searchVal, setSearchVal] = useState('');

    //검색 모달 열기
    const openSearch = () =>{
        setIsSearchOpen(true);
    }

    //검색 모달 닫기
    const closeSearch = () => {
        setIsSearchOpen(false);
    }

    //검색값 처리
    const handleValue = (e) => {
        setSearchVal(e.target.value);
    };

    // 엔터키 입력시 검색 수행
    const search = (e) => {
        if (e.keyCode === 13) {
            navigate('/all?keyword=${searchVal}');
            closeSearch();
        }
    }

    return(
    <>
    {/* 좌측 로고 */}
    <div className = "header_left">
        <a className = "header_left_logo" href='/'>
        <img src='logo.png' alt ="SimpleWeb" />
        </a>
    </div>

    {/* 우측 유틸리티 */}
    <div class="header_right">
        <div style="position: realative;" class="desktop-only">
            <a className='header_item' target='_blank' href='https://simpleweb.com/aboutMe'>
                제작자 소개
            </a>
            <a className='header_item' target='_self' href='https://simpleweb.com/aboutSite'>
                사이트 안내
            </a>
            <a className='header_item' onClick={openSearch}>
                검색
                {/**추후 아이콘으로 변경 modal 기능 사용할 것*/}
            </a>
            <a className='header_item' target='_self' href='https://simpleweb.com/aboutSite'>
                다크모드
                {/**추후 아이콘으로 변경 */}
            </a>
        </div>
    </div>

    {/* 검색 모달 */}
    {isSearchOpen && (
        <div className="search-modal">
            <h2>검색</h2>
            <input type="text" placeholder='검색어를 입력하세요' />
            <button onClick={closeSearch}>닫기</button>
        </div>
    )}



    {/* 중앙/하단 커뮤니티 카테고리 */}

    </>

    )

}

export default Header;