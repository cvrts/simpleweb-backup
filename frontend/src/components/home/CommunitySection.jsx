function CommunitySection() {
    const [activeTab, setActiveTab] = useState('market');
    const posts = {
        market: [/* 마켓 포스트 데이터 */],
        humor: [/* 유머 포스트 데이터 */],
        forum: [/* 포럼 포스트 데이터 */]
    };

    return (
        <div className="community-section">
            <div className="tabs">
                {Object.keys(posts).map(tab => (
                    <button
                        key={tab}
                        onClick={() => setActiveTab(tab)}
                        className={activeTab === tab ? 'active' : ''}
                    >
                        {tab}
                    </button>
                ))}
            </div>
            <div className="posts">
                {posts[activeTab].map(post => (
                    <div key={post.id} className="post">
                        <h3>{post.title}</h3>
                        <p>{post.content}</p>
                    </div>
                ))}
            </div>
            <button className="view-more" onClick={() => {/* 해당 카테고리로 이동 */ }}>
                더보기
            </button>
        </div>
    );
}