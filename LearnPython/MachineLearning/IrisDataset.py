from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
print("done")

iris = load_iris()
iris_data = iris.data # Features: sepal length, sepal width, petal length, petal width
iris_target = iris.target # Target labels: Iris Setosa (0), Versicolor (1), Virginica (2)

x_tarin, x_test, y_train, y_test = train_test_split(iris_data, iris_target, test_size=0.2, random_state=42)


ffnn = MLPClassifier(hidden_layer_sizes=(10,10,10), max_iter=1000, activation='relu', solver='adam', random_state=42)

ffnn.fit(x_test,y_test)

predictions = ffnn.predict(x_test)

print("Accuracy:", accuracy_score(y_test,predictions))
print("\nConfusion Matrix:\n", confusion_matrix(y_test, predictions))
print("\nClassification Report:\n", classification_report(y_test, predictions))