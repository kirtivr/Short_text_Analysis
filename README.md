# Short Text Analysis

## Project Overview
Short Text Analysis is a Java-based pipeline for processing and classifying short text content (for example, tweets). The project combines text preprocessing, feature extraction, dataset preparation, and machine-learning classification to support quick experimentation on short-message datasets.

At a high level, the application helps you:
- Clean and normalize raw short-text inputs
- Compute features used for model training/inference
- Convert processed data into ML-friendly ARFF format
- Train/evaluate classification models (Weka-based)
- Integrate data from files and SQL-backed sources where needed

---

## What the Application Does
The repository implements an end-to-end short-text classification workflow:
1. **Input ingestion** from local files and/or database-connected sources
2. **Text preprocessing** (token cleanup, normalization, and preparation)
3. **Feature extraction** from cleaned text records
4. **ARFF dataset generation** for Weka consumption
5. **Model execution and evaluation** through Weka-related classes
6. **Output artifacts** such as prepared datasets, model results, and evaluation summaries

This structure is useful for experimentation, baseline model comparisons, and extending short-text analytics pipelines.

---

## Code Walkthrough (Recommended Reading Path)
If you are new to the codebase, read files in this order:

1. **`Main`**
   - Entry point/orchestrator for pipeline execution.
   - Wires together preprocessing, feature extraction, data conversion, and model operations.

2. **`TweetProcess`**
   - Core text-processing stage.
   - Responsible for preparing raw tweet/short-text content for downstream feature computation.

3. **`FeatureExtract`**
   - Computes the engineered features used by classifiers.
   - Defines what information from each short text becomes model input.

4. **`MakeARFF`**
   - Converts processed examples + features into ARFF format.
   - Acts as the bridge from internal data structures to Weka-compatible datasets.

5. **Weka-related classes**
   - Train, evaluate, and potentially persist/compare models.
   - Encapsulate classifier choice, metrics, and evaluation flow.

6. **Data integration helpers (`ExcelToDB`, SQL/JDBC classes)**
   - Import/export and storage integration points.
   - Useful when data preparation and experiments involve database-backed workflows.

When making changes, start at `Main` to see control flow, then inspect each layer implementation.

---

## Technical Overview

### Layered Architecture
The project is organized in a practical layered style:

- **Orchestration layer**: `Main`
  - Controls execution order and high-level workflow.

- **Processing layer**: `TweetProcess`
  - Handles short-text cleanup and normalization logic.

- **Feature layer**: `FeatureExtract`
  - Produces model-relevant numeric/categorical signals.

- **Data preparation layer**: `MakeARFF`
  - Builds Weka-ready ARFF datasets.

- **Model layer**: Weka classes
  - Runs training/inference and computes evaluation metrics.

- **Integration layer**: `ExcelToDB`, SQL helpers
  - Connects external data sources/sinks to the analysis pipeline.

### Conceptual Data Flow
`Raw short text -> Preprocessing -> Feature extraction -> ARFF conversion -> Weka classification/evaluation -> Results`

### Major Dependencies and Integration Points
- **Java (core language/runtime)**
- **Weka APIs** for machine-learning models and evaluation
- **JDBC/SQL APIs** for database integration
- **File I/O** for dataset ingestion and artifact output

---

## Getting Started

### Prerequisites
- JDK 8+ (or the version used by your team)
- Build tooling available in this repo context (IDE/manual javac flow)
- Weka library/JAR configured in classpath
- Access to any required input files and (if used) SQL database credentials

### First Run Path
1. Clone the repository.
2. Import/open as a Java project in your IDE.
3. Ensure Weka and JDBC dependencies are resolvable in classpath.
4. Confirm input data locations and database configuration (if applicable).
5. Run the `Main` class.
6. Inspect generated ARFF files, model outputs, and evaluation results.

### Expected Inputs
- Short-text/tweet records (file or DB sourced)
- Optional metadata/labels needed for supervised training

### Expected Outputs
- Processed text representations
- Feature-enriched datasets
- ARFF files
- Classification/evaluation summaries

### First-Time Contributor Tips
- Trace one complete run through `Main` before changing logic.
- Make small, layer-scoped changes (processing vs feature vs model).
- Validate intermediate artifacts (especially ARFF structure) after edits.
- Update this README when behavior, architecture, or setup steps change.

---

## Documentation Standard (README Governance)
To keep project documentation useful, every PR should preserve and update this README when needed.

### Minimum Required README Sections
- Project overview and purpose
- Execution/getting-started instructions
- Code walkthrough of key classes
- Technical architecture and data flow
- Dependencies/integration requirements
- Inputs/outputs and expected artifacts

### PR Documentation Checklist
Before requesting review, confirm:
- [ ] Behavior changes are reflected in **Project Overview** or **What the Application Does**
- [ ] New/modified classes are reflected in **Code Walkthrough**
- [ ] Architecture/data flow updates are reflected in **Technical Overview**
- [ ] Setup/runtime dependency changes are reflected in **Getting Started**
- [ ] New required configs, inputs, or outputs are documented

If a code change affects how the system runs or is understood, README updates are required in the same PR.