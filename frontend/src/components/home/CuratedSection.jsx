function CuratedSection() {
    const curatedPosts = [/* 큐레이팅된 포스트 데이터 */];

    return (
        <div className="curated-section">
            <h2>Curated</h2>
            <div className="curated-posts">
                {curatedPosts.map(post => (
                    <div key={post.id} className="curated-post">
                        <img src={post.image} alt={post.title} />
                        <h3>{post.title}</h3>
                    </div>
                ))}
            </div>
        </div>
    );
}